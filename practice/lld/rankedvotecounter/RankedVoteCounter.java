package rankedvotecounter;

import java.util.*;
import java.io.*;

public class RankedVoteCounter {

    // Map to store total score accumulated by each candidate
    private Map<String, Integer> scoreMap = new HashMap<>();

    /**
     * Reads a large file containing millions of votes in a memory-efficient way.
     * Each line in the file represents a single vote (ranked list of candidates).
     * Processes votes in batches to avoid loading the entire file into memory.
     *
     * @param file The file containing votes
     * @param batchSize Number of votes to process in each batch
     */
    public void processVotesInBatches(File file, int batchSize) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> batch = new ArrayList<>();  // temporary batch storage
            String line;

            // Read the file line-by-line
            while ((line = reader.readLine()) != null) {
                batch.add(line); // collect votes into the current batch

                // Once batch is full, process it and clear the list
                if (batch.size() == batchSize) {
                    processBatch(batch);
                    batch.clear(); // free up memory
                }
            }

            // Process any remaining votes that didn't fill up a full batch
            if (!batch.isEmpty()) {
                processBatch(batch);
            }
        }
    }

    /**
     * Processes a batch of vote strings and updates the candidate scores.
     * Assumes each vote is a comma-separated list of candidate names, in ranked order.
     *
     * Example: "Alice,Bob,Charlie" -> Alice gets 3 pts, Bob gets 2, Charlie gets 1
     *
     * @param batch List of vote strings
     */
    private void processBatch(List<String> batch) {
        for (String voteLine : batch) {
            String[] rankedCandidates = voteLine.split(",");  // split vote by ranking

            // Assign points in reverse order: 1st = most points
            for (int i = 0; i < rankedCandidates.length; i++) {
                String candidate = rankedCandidates[i].trim(); // remove whitespace
                int points = rankedCandidates.length - i;      // higher rank = more points

                // Add points to the candidate’s total
                scoreMap.put(candidate, scoreMap.getOrDefault(candidate, 0) + points);
            }
        }
    }

    /**
     * Returns the final ranked result of candidates, sorted by total score in descending order.
     *
     * @return List of entries where each entry is (candidate, score), ranked by score
     */
    public List<Map.Entry<String, Integer>> getRankedResults() {
        List<Map.Entry<String, Integer>> result = new ArrayList<>(scoreMap.entrySet());

        // Sort candidates from highest to lowest score
        result.sort((a, b) -> b.getValue() - a.getValue());
        return result;
    }
}
