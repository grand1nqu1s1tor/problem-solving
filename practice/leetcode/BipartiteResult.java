package leetcode;

class BipartiteResult {
    boolean isBipartite;
    int[] colors;

    BipartiteResult(boolean isBipartite, int[] colors) {
        this.isBipartite = isBipartite;
        this.colors = colors;
    }

    // Method to get the output as a string message
    public String getOutput() {
        if (!isBipartite) {
            return "Not possible";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Group 1: ");
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == 0) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\nGroup 2: ");
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == 1) {
                    sb.append(i).append(" ");
                }
            }
            return sb.toString().trim();
        }
    }
}

// Rest of the code remains the same as previously provided.
