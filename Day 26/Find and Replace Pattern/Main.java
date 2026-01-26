import java.util.*;

class Result {
    int matchedCount;
    List<String> matchedWords;

    Result(int matchedCount, List<String> matchedWords) {
        this.matchedCount = matchedCount;
        this.matchedWords = matchedWords;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.add(scanner.next());
        }

        String pattern = scanner.next();
        scanner.close();

        Result result = findAndReplacePattern(words, pattern);

        System.out.println(result.matchedCount);
        if (result.matchedCount > 0) {
            System.out.println(String.join(" ", result.matchedWords));
        }
        scanner.close();
    }

    public static Result findAndReplacePattern(List<String> words, String pattern) {
        List<String> matchedWords = new ArrayList<>();

        for (String word : words) {
            if (word.length() != pattern.length()) continue;

            if (matches(word, pattern)) {
                matchedWords.add(word);
            }
        }

        return new Result(matchedWords.size(), matchedWords);
    }

    private static boolean matches(String word, String pattern) {
        Map<Character, Character> patternToWord = new HashMap<>();
        Map<Character, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (patternToWord.containsKey(p)) {
                if (patternToWord.get(p) != w) return false;
            } else {
                patternToWord.put(p, w);
            }

            if (wordToPattern.containsKey(w)) {
                if (wordToPattern.get(w) != p) return false;
            } else {
                wordToPattern.put(w, p);
            }
        }
        return true;
    }
}
