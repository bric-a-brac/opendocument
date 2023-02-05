
import java.util.prefs.Preferences;

import io.github.fabricetheytaz.opendocument.IOpenDocument;

public class Dev
	{
	public static void main(String[] args) throws Exception
		{
		final Preferences preferences = Preferences.userNodeForPackage(IOpenDocument.class);

		//preferences.put("sdd", "sfdsdfsdf");
		//preferences.flush();

		String dss = preferences.get("sdd", null);
		System.out.println(dss);
		}
	}
