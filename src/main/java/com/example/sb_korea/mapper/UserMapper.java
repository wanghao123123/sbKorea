package com.example.sb_korea.mapper;

import com.example.sb_korea.utils.DateUtils;
import com.example.sb_korea.vo.UserDTO;
import com.example.sb_korea.vo.UserVO;
import org.mapstruct.*;

import java.util.List;

/**
 * @author hao.wong
 * @date 2021/12/24
 */
@Mapper(componentModel="spring")
public abstract class UserMapper {

    @Mapping(target = "userName",source = "name")
    @Mapping(target = "userAge",source = "age")
    @Mapping(expression = "java(com.example.sb_korea.utils.DateUtils.parse(dto.getTime()))",target = "localDateTime")
    public abstract UserVO toVO(UserDTO dto);

    @Mapping(target = "userName",source = "name")
    @Mapping(target = "userAge",source = "age")
    @Mapping(expression = "java(com.example.sb_korea.utils.DateUtils.parse(dto.getTime()))",target = "localDateTime")
    public abstract List<UserVO> toVO(List<UserDTO> dto);


    @BeforeMapping
    public void before(UserDTO dto,@MappingTarget UserVO vo){
        vo.setBefore("before");
    }

    @AfterMapping
    public void after(UserDTO dto,@MappingTarget UserVO vo){
        vo.setAfter("after");
    }

    @AfterMapping
    public void afterList(List<UserDTO> dtos,@MappingTarget List<UserVO> vos){
        for (UserVO vo : vos) {
            System.err.println(vo.getUserName());
        }
    }

}
