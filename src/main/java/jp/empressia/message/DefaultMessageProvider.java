package jp.empressia.message;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * message.propertiesを読み込んで提供するProviderです。
 * 以下の順で読み込むリソースを特定します。
 * １．システムプロパティ『jp.empressia.message.DefaultMessageProvider.BasePath』(クラス名＋フィールド名から）。
 * ２．リソース『message』
 * ３．リソース『messages』
 * @author すふぃあ
 */
public class DefaultMessageProvider implements MessageProvider {

	/** 読み込むリソースへのパスです。 */
	private String BasePath;

	/** リソースを検出する候補です。先のものほど、優先度高く採用されます。 */
	private String[] DETECT_BASE_PATHS = {"message", "messages"};

	/** コンストラクタ。 */
	public DefaultMessageProvider() {
		this.initializeMessageResourceName();
	}

	/** リソースの名前を決定します。 */
	public void initializeMessageResourceName() {
		// システムプロパティからを優先とします。
		String basePath = System.getProperty(this.getClass().getName() + "." + "BasePath");
		// なければ、探します。
		if(basePath == null) {
			for(String path : DETECT_BASE_PATHS) {
				try {
					ResourceBundle.getBundle(path);
				} catch(MissingResourceException ex) {
					// 存在しないので次へ。
					continue;
				}
				basePath = path;
			}
		}
		// それでもなければ、一応、最優先のものを指定しておきます。
		if(basePath == null) {
			basePath = DETECT_BASE_PATHS[0];
		}
		this.BasePath = basePath;
	}

	/** Localeにあったメッセージ、および、メッセージのテンプレートを提供します。 */
	public String get(String ID, Locale locale) {
		ResourceBundle resource = ResourceBundle.getBundle(this.BasePath, locale);
		String message = resource.getString(ID);
		return message;
	}

}
