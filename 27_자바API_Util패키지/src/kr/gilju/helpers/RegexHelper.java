package kr.gilju.helpers;

import java.util.regex.Pattern;
import kr.gilju.exceptions.StrigFormatException;


public class RegexHelper {
    private static  RegexHelper current;

    public static  RegexHelper getInstance() {
        if (current == null) {
            current = new  RegexHelper();
        }

        return current;
    }

    private  RegexHelper() {
        super();
    }


/**
 * 문자열이 공백이거나 널 인지를 검사
 * 
 * @param str
 * @param message
 * @throws StrigFormatException
 */

public void isValue(String str, String message) throws StrigFormatException {
  if (str == null || str.trim().equals("")){
    throw new StrigFormatException(message);
  }
}

/**
 * 숫자 모양에 대한 형식검사
 * 
 * @param str
 * @param message
 * @throws StrigFormatException
 */

public void isNum(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^[0-9]*$" , str)){
    throw new StrigFormatException(message);
  }
}



/**
 * 영문검사
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void isEng(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^[a-zA-Z]*$" , str)){
    throw new StrigFormatException(message);
  }
}



/**
 * 한글검사
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void iskor(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^[ᄀ-ᄒ가-힣]*$" , str)){
    throw new StrigFormatException(message);
  }
}


/**
 * 영문, 숫자 검사
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void isEngNum(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^[a-zA-Z0-9]*$", str)){
    throw new StrigFormatException(message);
  }
}


/**
 * 한글/숫자 검사
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void isKorNum(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^[ᄀ-ᄒ가-힣0-9]*$", str)){
    throw new StrigFormatException(message);
  }
}


/**
 * 이메일검사
 * @param str
 * @param message
 * @throws StrigFormatException
 */

public void isEmail(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]
{2})?)$"i, str)){
    throw new StrigFormatException(message);
  }
}



/**
 * 핸드폰번호
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void isCellPhone(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str)){
    throw new StrigFormatException(message);
  }
}



/**
 * 집번호
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void isTel(String str, String message) throws StrigFormatException {
  if (!Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str)){
    throw new StrigFormatException(message);
  }
}


/**
 * 집번호 혹은 핸드폰 번호 둘중 하나 충족검사
 * @param str
 * @param message
 * @throws StrigFormatException
 */
public void isPhone(String str, String message) throws StrigFormatException {
  boolean cellPhone = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message)
  boolean telPhone = Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", message)

  if (!cellPhone && !telPhone){
    throw new StrigFormatException(message);
  }
}
}