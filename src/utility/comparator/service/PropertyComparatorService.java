package utility.comparator.service;

import java.util.Properties;

import resources.ComparisonResults;

public interface PropertyComparatorService {

	ComparisonResults comparePropertiesOf(Properties a, Properties b);
}
