package truecorp.ensemble.utils;

import truecorp.core.model.M203UserDto;
import truecorp.core.session.Session;

/**
 * Created by Jennarong Pinjai on 9/2/2561.
 */

public class UserUtils {

    public static M203UserDto getUser(){

        try {


            M203UserDto user = (M203UserDto)Session.getAttribute("user");
            return  user;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;

        }
    }

}
