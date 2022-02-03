package Praktikum.com;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name == null)
            return false;

        int spaceCount = name.length() - name.replaceAll(" ", "").length();

            if (name.startsWith(" ") | name.endsWith(" ")) {
                System.out.println("Печать Отклонена.Пробел не может стоять в начале или в конце строки.");
                return false;
            } else if (name.length() < 3 | name.length() > 19) {
                System.out.println("Печать отклонена. Неподходящая по длинне строка.");
                return false;
            } else if (spaceCount == 0 | spaceCount > 1) {
                System.out.println("Печать отклонена.Отсутствует пробел, либо число пробелов между словами больше одного.");
                return false;


            }
            System.out.println("Печатать можно");
            return true;
        }

    }
