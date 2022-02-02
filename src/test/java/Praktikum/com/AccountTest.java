package Praktikum.com;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String checkedValue;
    private final boolean expected;
    private final String testlable;


    public AccountTest(String testlable,String checkedValue,boolean expected) {
        this.testlable = testlable;
        this.checkedValue = checkedValue;
        this.expected = expected;

    }


    @Parameterized.Parameters(name = "{0}: {1} = {2}")
    public static Object[][] getTextData(){
        return new Object[][] {
                {"Проверка  NULL",null, false},
                {"0 символов","", false},
                {"2 символа слитно","12", false},
                {"3 символа слитно","123", false},
                {"3 символа(пробел по середине)","1 3", true},
                {"4 символа(пробел по середине)","12 4", true},
                {"11 символов(пробел по середине)","12345 78901", true},
                {"19 символов(пробел по середине)","123456789 123456789", true},
                {"20 символов(пробел по середине)","1234567890 123456789", false},
                {"25 символов(пробел по середине)","123456789012 123456789012", false},
                {"Два пробела по середине","Дмитрий  Дмитриев", false},
                {"Пробел в начале строки"," Дмитрий Дмитриев", false},
                {"Пробел в конце строки","Дмитрий Дмитриев ", false},
                {"Пробелв в начале и в конце строки"," Дмитрий Дмитриев ", false},

        };
    }


    @Description("Проверяем Позитивные и негативные сценарии.")
    @Test
    public void paramAccountTest()  {
        Account account = new Account(checkedValue);
        assertEquals(expected, account.checkNameToEmboss());
    }


}
