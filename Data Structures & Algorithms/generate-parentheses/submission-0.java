class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        backtrack(0, 0, n, res, st);
        return res;
    }
    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder st) {
        if (openN == closedN && openN == n) {
            res.add(st.toString());
            return;
        }

        if (openN < n) {
            st.append('(');
            backtrack(openN + 1, closedN, n, res, st);
            st.deleteCharAt(st.length() - 1);
        }
        if (closedN < openN) {
            st.append(')');
            backtrack(openN, closedN + 1, n, res, st);
            st.deleteCharAt(st.length() - 1);
        }

    }
}
