package jp.empressia.message;

import java.util.Locale;

/**
 * メッセージ用の文字列を提供するProvider定義です。
 * @author すふぃあ
 */
@FunctionalInterface
public interface MessageProvider {
	/** Localeにあったメッセージ、および、メッセージのテンプレートを提供します。 */
	public String get(String ID, Locale locale);
}
