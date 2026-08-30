public class LibraryIsbnNormalizerValidator {
    static String normalizeCode(String raw) {
        String code = raw.trim();
        String publisherCode = code.substring(0, 3).toUpperCase();
        String remainingCode = code.substring(3);
        return publisherCode + remainingCode;
    }
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }
        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);
        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(publisherCode)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }
    public static void main(String[] args) {
        String rawCode = " pen2026004251 ";
        String normalizedCode = normalizeCode(rawCode);
        String result = validateAndFormat(normalizedCode);
        System.out.println(result);
    }
}
