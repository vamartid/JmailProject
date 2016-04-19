/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vamartid.test1.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author basilism
 */
public class ValidatorMail {

    private Pattern pattern;
    private Matcher matcher;
//    private Pattern pattern2;
//    private Matcher matcher2;

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//    private static final String BIRTHDAY_PATTERN
//            = "^[A-Za-z0-9-]{2,}(\\.[_A-Za-z0-9-]{2,}./)(\\.[_A-Za-z0-9-]{2,}./) $";

    public ValidatorMail() {
        pattern = Pattern.compile(EMAIL_PATTERN);
//        pattern2 = Pattern.compile(BIRTHDAY_PATTERN);
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }

//    public boolean validate2(final String hex) {
//
//        matcher2 = pattern2.matcher(hex);
//        return matcher2.matches();
//
//    }
}
