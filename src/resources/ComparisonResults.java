package resources;

import java.util.Properties;
import java.util.Set;

public class ComparisonResults {

	private Properties a;
	private Properties b;
	private Properties onlyA;
	private Properties onlyB;
	private Properties both;

	private Set<Object> unionOfBothKeySet;

	public ComparisonResults(Properties a, Properties b) {
		this.a = a;
		this.b = b;
	}

	public Properties getA() {
		return a;
	}

	public Properties getB() {
		return b;
	}

	public Properties getBoth() {
		return both;
	}

	public Properties getOnlyA() {
		return onlyA;
	}

	public Properties getOnlyB() {
		return onlyB;
	}

	public Set<Object> getUnionOfBothKeySet() {
		return unionOfBothKeySet;
	}

	public void setBoth(Properties both) {
		this.both = both;
	}

	public void setOnlyA(Properties onlyA) {
		this.onlyA = onlyA;
	}

	public void setOnlyB(Properties onlyB) {
		this.onlyB = onlyB;
	}

	public void setUnionOfBothKeySet(Set<Object> unionOfBothKeySet) {
		this.unionOfBothKeySet = unionOfBothKeySet;
	}

}
