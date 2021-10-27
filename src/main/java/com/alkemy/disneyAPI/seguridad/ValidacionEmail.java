package com.alkemy.disneyAPI.seguridad;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;

@Service
public class ValidacionEmail implements Predicate<String>{
    @Override
    public boolean test(String s) {
        return true;
    }
}
