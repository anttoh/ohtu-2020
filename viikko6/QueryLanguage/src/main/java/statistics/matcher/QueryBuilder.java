package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        resetOrInitializeMatcher();
    }

    public Matcher build() {
        Matcher compeletdMatcher = this.matcher;
        resetOrInitializeMatcher();
        return compeletdMatcher;
    }

    public QueryBuilder playsIn(String team) {
        linkNewMatcherToThisMatcher(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        linkNewMatcherToThisMatcher(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        linkNewMatcherToThisMatcher(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    private void linkNewMatcherToThisMatcher(Matcher newMatcher) {
        this.matcher = new And(this.matcher, newMatcher);
    }

    private void resetOrInitializeMatcher() {
        this.matcher = new All();
    }
}
