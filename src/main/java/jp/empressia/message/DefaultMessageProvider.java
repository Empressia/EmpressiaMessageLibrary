package jp.empressia.message;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * locationで指定されたリソースのプロパティを読み込んで提供するProviderです。
 * @author すふぃあ
 */
public class DefaultMessageProvider implements MessageProvider {

	/** コンストラクタ。 */
	public DefaultMessageProvider() {
	}

	/** Localeにあったメッセージ、および、メッセージのテンプレートを提供します。 */
	public String get(String location, String ID, Locale locale) {
		ResourceBundle resource = ResourceBundle.getBundle(location, locale);
		String message = resource.getString(ID);
		return message;
	}

}
