class MicroBlog {
    public String truncate(String input) {
        // return substring of input string, start from string index 0
        return input.substring(0,
        //maximum 5 codePoints, so set maximum to offset from 0 to 1-5 codepoints
        input.offsetByCodePoints(0, Math.min(input.codePointCount(0, input.length()), 5)));
    }
}
