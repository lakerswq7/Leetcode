package string;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        char[] array = s.toCharArray();
        int start = 0, end = array.length - 1;
        while (start < end) {
            while (!vowels.contains(String.valueOf(array[start])) && start < end) {
                start++;
            }
            while (!vowels.contains(String.valueOf(array[end])) && start < end) {
                end--;
            }
            swap(array, start, end);
            start++;
            end--;
        }
        return String.valueOf(array);
    }
    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
