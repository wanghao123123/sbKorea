package com.example.sb_korea.transaction;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;

/**
 * @author hao.wong
 * @date 2022/1/12
 */
public interface TransactionApi {

    /**
     * execute the action specified by the given callback object and transaction definition.
     * @param transactionDefinition  the transaction definition
     * @param action the callback object that specifies the transactional action
     * @return a result object returned by the callback, or {@code null} if none
     * @throws TransactionException in case of initialization, rollback, or system errors
     * @throws RuntimeException if thrown by the TransactionCallback
     */
    <T> T execute(TransactionDefinition transactionDefinition, TransactionCallback<T> action) throws TransactionException;

    /**
     * execute the action specified by the given callback object with default transaction definition.
     * @param action the callback object that specifies the transactional action
     * @return a result object returned by the callback, or {@code null} if none
     * @throws TransactionException in case of initialization, rollback, or system errors
     * @throws RuntimeException if thrown by the TransactionCallback
     */
    <T> T execute(TransactionCallback<T> action) throws TransactionException;

}
