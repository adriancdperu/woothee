package is.tagomor.woothee.hive;

import java.util.Map;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import is.tagomor.woothee.DataSet;

@Description(name="is_appliance",
             value="_FUNC_ return Boolean: map['category'] is an appliance or not",
             extended="WHERE _FUNC_(parse_agent(user_agent_string)) AND ...")
public final class IsAppliance extends UDF {
  public Boolean evaluate(final Map<String,String> m) {
    return m.get(DataSet.ATTRIBUTE_CATEGORY).equals(DataSet.DATASET_CATEGORY_APPLIANCE);
  }
}