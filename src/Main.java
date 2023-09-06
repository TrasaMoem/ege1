import java.util.Arrays;

class Main {
    private static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static void permutations(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        if (str.length() == 1) {
            System.out.print(str);
            return;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        int n = str.length();

        while (true) {
            System.out.print(String.valueOf(chars) + " ");

            int i = n - 1;
            while (chars[i-1] >= chars[i]) {
                if (--i == 0) {
                    return;
                }
            }

            int j = n - 1;
            while (j > i && chars[j] <= chars[i-1]) {
                j--;
            }
            swap(chars, i - 1, j);
            reverse (chars, i, n - 1);
        }
    }

    public static void main(String[] args) {
        String t = "13 14 16 25 27 31 34 41 43 47 52 56 57 61 65 72 74 75",
                g = "ВБ БВ ВГ ГВ БА АБ БД ДБ АД ДА ГЕ ЕГ ГЖ ЖГ ЕЖ ЖЕ ДЕ ЕД";
        String s = "АБВГДЕК";
        permutations(s);

    }
}