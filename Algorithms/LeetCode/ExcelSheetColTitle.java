package LeetCode;

class ExcelSheetColTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            
            int remainder = columnNumber % 26;
            
            char letter = (char) ('A' + remainder);
            
            result.insert(0, letter);
            
            columnNumber /= 26;
        }
        
        return result.toString();
    }
}