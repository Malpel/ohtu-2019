package statistics.matcher;

import statistics.Player;

import java.util.ArrayList;

public class QueryBuilder {

    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
    }

    public Matcher build() {
        matchers.add(new All());
        ArrayList<Matcher> matcherListForAnd = new ArrayList<>();
        matcherListForAnd.addAll(matchers);
        matchers.clear();
        return new And(matcherListForAnd);
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public Matcher oneOf(Matcher... matchers) {
        return new Or(matchers);
    }

}
