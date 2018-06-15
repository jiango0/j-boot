package com.jzc.spring.boot.test;

import com.jzc.spring.boot.test.optional.AddressEntity;
import com.jzc.spring.boot.test.optional.CountryEntity;
import com.jzc.spring.boot.test.optional.UserEntity;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalProcessorTest {

    @Test
    public void optionalTest() {
        UserEntity user = createUserEntity();

        outPrint(
                Optional.ofNullable(user)
                        .map(u -> user.getIsEmpty())
                        .orElse("isEmpty is null")
        );
        outPrint(
                Optional.ofNullable(user)
                        .map(UserEntity::getName)
                        .orElse("name is empty")
        );
        outPrint(
                Optional.ofNullable(user)
                        .map(UserEntity::getId)
                        .orElseThrow(() -> new IllegalArgumentException("参数错误"))
        );
        outPrint(
                Optional.ofNullable(user)
                        .map(UserEntity::getAddress)
                        .map(AddressEntity::getCountry)
                        .map(CountryEntity::getMap)
                        .orElseThrow(() -> new IllegalArgumentException("map is empty")).get("name")
        );

    }

    private void outPrint(Object object) {
        System.out.println(object);
    }

    private UserEntity createUserEntity() {
        UserEntity user = new UserEntity();
        AddressEntity address = new AddressEntity();
        CountryEntity country = new CountryEntity();
        Map<String, String> map = new HashMap<>();
        country.setMap(map);
        address.setCountry(country);
        user.setAddress(address);

        map.put("email", "switchrouter@qq.com");
        map.put("name", "姜志超");

        country.setId(System.currentTimeMillis());
        country.setName("武汉");
        address.setId(System.currentTimeMillis());
        address.setContext("马鹦路兰亭都会");
        user.setId(System.currentTimeMillis());
        user.setName("姜志超");

        return user;
    }

}
