package com.example.sb_korea.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;

import javax.annotation.Resource;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author hao.wong
 * @date 2022/1/12
 */
@Service
public class TransactionApiImpl implements TransactionApi{

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionApiImpl.class);

    @Resource
    private DataSourceTransactionManager transactionManager;

    @Override
    public <T> T execute(TransactionDefinition transactionDefinition, TransactionCallback<T> action) throws TransactionException {
        TransactionStatus status = this.transactionManager.getTransaction(transactionDefinition);
        T result;
        try {
            result = action.doInTransaction(status);
        }
        catch (RuntimeException ex) {
            // Transactional code threw application exception -> rollback
            rollbackOnException(status, ex);
            throw ex;
        }
        catch (Error err) {
            // Transactional code threw error -> rollback
            rollbackOnException(status, err);
            throw err;
        }
        catch (Throwable ex) {
            // Transactional code threw unexpected exception -> rollback
            rollbackOnException(status, ex);
            throw new UndeclaredThrowableException(ex, "TransactionCallback threw undeclared checked exception");
        }
        this.transactionManager.commit(status);
        return result;
    }

    @Override
    public <T> T execute(TransactionCallback<T> action) throws TransactionException {
        return this.execute(new DefaultTransactionDefinition(), action);
    }

    /**
     * Perform a rollback, handling rollback exceptions properly.
     * @param status object representing the transaction
     * @param ex the thrown application exception or error
     * @throws TransactionException in case of a rollback error
     */
    private void rollbackOnException(TransactionStatus status, Throwable ex) throws TransactionException {
        try {
            this.transactionManager.rollback(status);
        }
        catch (TransactionSystemException ex2) {
            LOGGER.error("Application exception overridden by rollback exception", ex);
            ex2.initApplicationException(ex);
            throw ex2;
        }
        catch (RuntimeException ex2) {
            LOGGER.error("Application exception overridden by rollback exception", ex);
            throw ex2;
        }
        catch (Error err) {
            LOGGER.error("Application exception overridden by rollback error", ex);
            throw err;
        }
    }
}
