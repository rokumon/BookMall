package cn.mislily.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class ParameterUtils {

    public static <T> T copyToBean(Map<String,String[]> src, T des){

        try {

            BeanUtils.populate(des, src);

            return des;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
