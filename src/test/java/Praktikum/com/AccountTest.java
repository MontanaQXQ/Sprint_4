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


    public AccountTest(String checkedValue,boolean expected) {
        this.checkedValue = checkedValue;
        this.expected = expected;

    }


    @Parameterized.Parameters
    public static Object[][] getTextData(){
        return new Object[][] {

                {null, false},
                {"", false},
                {"12", false},
                {"123", false},
                {"1 3", true},
                {"12 4", true},
                {"12345 78901", true},
                {"123456789 123456789", true},
                {"1234567890 123456789", false},
                {"123456789012 123456789012", false},
                {"Дмитрий  Дмитриев", false},
                {"Дмитрий Дмитриев", true},
                {" Дмитрий Дмитриев", false},
                {"Дмитрий Дмитриев ", false},
                {" Дмитрий Дмитриев ", false},

        };
    }

    @DisplayName("Тест кейс")
    @Description("Проверяем Позитивные и негативные сценарии.")
    @Test
    public void paramAccountTest()  {
        Account account = new Account(checkedValue);
        assertEquals(expected, account.checkNameToEmboss());
    }


}
