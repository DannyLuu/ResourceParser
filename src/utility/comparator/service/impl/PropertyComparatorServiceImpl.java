package utility.comparator.service.impl;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import resources.ComparisonResults;
import utility.comparator.service.PropertyComparatorService;

public class PropertyComparatorServiceImpl implements PropertyComparatorService {

	private static final Logger log = Logger.getLogger(PropertyComparatorServiceImpl.class);

	@Override
	public ComparisonResults comparePropertiesOf(Properties a, Properties b) {
		ComparisonResults results = new ComparisonResults(a, b);
		log.info("The size of a: " + results.getA().size());
		log.info("The size of b: " + results.getB().size());

		compareResultsForOnlyAandB(results);
		compareResultsForBothAandB(results);
		joinAandNB(results);

		if (results.getOnlyA() != null) {
			log.info("The size of only a: " + results.getOnlyA().size());
		}

		if (results.getOnlyB() != null) {
			log.info("The size of only b: " + results.getOnlyB().size());
		}

		if (results.getBoth() != null) {
			log.info("The size of A and B: " + results.getBoth().size());
		}

		return results;
	}

	private void compareResultsForBothAandB(ComparisonResults results) {
		Properties bothAandB = new Properties();

		bothAandB.putAll(results.getOnlyA());
		results.getOnlyA().keySet().stream().forEach(k -> bothAandB.remove(k));
		results.setBoth(bothAandB);
	}

	private void compareResultsForOnlyAandB(ComparisonResults results) {
		results.setOnlyA(compareResultsForOnlyX(results.getA(), results.getB()));
		results.setOnlyB(compareResultsForOnlyX(results.getB(), results.getA()));
	}

	private Properties compareResultsForOnlyX(Properties x, Properties z) {
		Properties onlyX = new Properties();

		Set<Object> keysToRemove = z.keySet();
		onlyX.putAll(x);
		keysToRemove.stream().forEach(k -> onlyX.remove(k));

		return onlyX;
	}

	private void joinAandNB(ComparisonResults results) {
		Set<Object> AnBKeys = new HashSet<>();
		AnBKeys.addAll(results.getA().keySet());
		AnBKeys.addAll(results.getB().keySet());

		results.setUnionOfBothKeySet(AnBKeys);
	}
}
