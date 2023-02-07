import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Dev
	{
	public static void emojis() throws IOException, URISyntaxException
		{
		try (final InputStream stream = Dev.class.getResourceAsStream("/emojis.properties"))
			{
			try (final Reader reader = new InputStreamReader(stream, StandardCharsets.ISO_8859_1))
				{
				final Properties properties = new Properties();

				properties.load(stream);

				System.out.println(properties.getProperty("water closet"));
				}
			//System.out.println(properties.getProperty("face blowing a kiss"));
			//System.out.println("👺");
			}

		try (final Reader reader = new FileReader("src/main/resources/emojis.properties"))
			{
			final Properties properties = new Properties();

			properties.load(reader);

			System.out.println(properties.getProperty("water closet"));
			}

		try (final Reader reader = new FileReader(new File(Dev.class.getResource("/emojis.properties").toURI())))
			{
			final Properties properties = new Properties();

			properties.load(reader);

			System.out.println(properties.getProperty("water closet"));
			}
		}

	public static void main(String[] args) throws Exception
		{
		emojis();

		//final Preferences preferences = Preferences.userNodeForPackage(IOpenDocument.class);
		//preferences.put("sdd", "sfdsdfsdf");
		//preferences.flush();
		//String dss = preferences.get("sdd", null);
		//System.out.println(dss);
		}
	}
