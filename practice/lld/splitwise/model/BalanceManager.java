public class BalanceManager {

    //Amount one user(Key) : owes to user B(Value)
    private Map<String, Map<String, Double>> balances;

    public BalanceManager() {
        balances = new HashMap<>();
    }

    //Update the balances bi directionally
    public void updateBalance(String payerId, String lenderId, Double amount) {
        balances.putIfAbsent(payerId, new HashMap<>());
        Double currentBalance = balances.get(payerId).getOrDefault(lenderId, 0.0);
        Double settledBalance = currentBalance - amount;
        balances.get(payerId).put(lenderId, settledBalance);

        balances.putIfAbsent(lenderId, new HashMap<>());
        currentBalance = balances.get(lenderId).getOrDefault(lenderId, 0);
        settledBalance = currentBalance + amount;
        balances.get(lenderId).put(lenderId, settledBalance);
    }

    //Show balances in the group
    public void showBalances() {
        for (Map.Entry<String, Map<String, Double>> balance : balances.entrySet()) {
            String payerId = balance.getKey();
            Map<String, Double> lenderBalances = balance.getValue();

            for (Map.Entry<String, Double> innerEntry : lenderBalances.entrySet()) {
                String lenderId = innerEntry.getKey();
                Double amount = innerEntry.getValue();

                System.out.println(payerId + "owes" + lenderId + "an amount of " + amount);
            }
        }
    }

}