

public class Contents {

	/**
	 * Activity页模板
	 * 
	 * @param name
	 * @param time
	 * @return
	 */
	public static String getActivityString(String name, String time) {
		String contentString = "/**\n" + " * @Info\n" + " * @Auth Bello\n"
				+ " * @Time "
				+ time
				+ "\n"
				+ " * @Ver\n"
				+ " */\n"
				+ "public class "
				+ name
				+ "Activity extends BaseActivity implements I"
				+ name
				+ "View, View.OnClickListener {\n"
				+ "private Context mContext;\n"
				+ "private Dialog loadingDialog;\n\n"
				+ "private TextView pageTitleText, backText;\n\n"
				+ "private I"
				+ name
				+ "Presenter presenter;\n\n"
				+ "@Override\n"
				+ "protected void onCreate(Bundle savedInstanceState) {\n"
				+ "super.onCreate(savedInstanceState);\n"
				+ "setContentView(R.layout.activity_);\n"
				+ "mContext = this;\n"
				+ "loadingDialog = ProgressUtils.loadCircleProgress(mContext, getString(R.string.loading), true);\n\n"
				+ "initUI();\n\n"
				+ "presenter = new "
				+ name
				+ "PresenterImpl(this);\n\n"
				+ "}\n\n"
				+ "/**\n"
				+ " * 初始化UI\n"
				+ " */\n"
				+ "private void initUI() {\n\n"
				+ "//顶部\n"
				+ "pageTitleText = (TextView) findViewById(R.id.top_center_text);\n"
				+ "pageTitleText.setText(\"\");\n"
				+ "backText = (TextView) findViewById(R.id.top_back_text);\n"
				+ "backText.setOnClickListener(this);\n\n"
				+ "}\n\n"
				+ "@Override\n"
				+ "public void onClick(View v) {\n"
				+ "switch (v.getId()){\n"
				+ "//返回\n"
				+ "case R.id.top_back_text:\n"
				+ "go();\n"
				+ "break;\n\n"
				+ "default:\n"
				+ "break;\n"
				+ "}\n"
				+ "}\n\n"
				+ "@Override\n"
				+ "public void setToast(String msg) {\n"
				+ " ShowUtil.toast(mContext, msg);\n"
				+ "}\n\n"
				+ "@Override\n"
				+ "public void setProgressDialog(boolean isShow) {\n"
				+ "if (loadingDialog != null) {\n"
				+ "if (isShow) {\n"
				+ " loadingDialog.show();\n"
				+ " } else {\n"
				+ "loadingDialog.cancel();\n"
				+ " }\n"
				+ " }\n"
				+ " }\n"
				+ " @Override\n"
				+ " public void go() {\n"
				+ "finish();\n"
				+ "}\n\n"
				+ "@Override\n"
				+ "protected void onDestroy() {\n"
				+ "super.onDestroy();\n"
				+ "presenter.onDestroy();\n"
				+ "}\n\n"
				+ "}\n";

		return contentString;
	}

	/**
	 * View页模板
	 * 
	 * @param name
	 * @param time
	 * @return
	 */
	public static String getView(String name, String time) {
		String content = "/**\n" + " * @Info\n" + " * @Auth Bello\n"
				+ " * @Time " + time + "\n" + " * @Ver\n" + " */\n"
				+ "public interface I" + name + "View extends IBaseView {\n"
				+ "}";

		return content;
	}

	/**
	 * Interface页模块
	 * 
	 * @param name
	 * @param time
	 * @return
	 */
	public static String getInterface(String name, String time) {
		String content = "/**\n" + " * @Info\n" + " * @Auth Bello\n"
				+ " * @Time " + time + "\n" + " * @Ver\n" + " */\n"
				+ "public interface I" + name
				+ "Presenter extends IBasePresenter {\n\n" + "}";

		return content;
	}

	public static String getImpl(String name, String lowName, String time) {
		String content = "/**\n" + " * @Info\n" + " * @Auth Bello\n"
				+ " * @Time "
				+ time
				+ "\n"
				+ " * @Ver\n"
				+ " */\n"
				+ "public class "
				+ name
				+ "PresenterImpl extends HttpRequestImpl implements I"
				+ name
				+ "Presenter {\n"
				+ "String TAG = \""
				+ name
				+ "PresenterImpl\";\n"
				+ "private I"
				+ name
				+ "View "
				+ lowName
				+ "View;\n"
				+ "private Handler mHandler;\n\n"
				+ "public "
				+ name
				+ "PresenterImpl(I"
				+ name
				+ "View "
				+ lowName
				+ "View) {\n"
				+ "super((Context) "
				+ lowName
				+ "View);\n"
				+ "this."
				+ lowName
				+ "View = "
				+ lowName
				+ "View;\n\n"
				+ "mHandler = new Handler(Looper.getMainLooper());\n\n"
				+ "}\n\n"
				+ "@Override\n"
				+ "public void postResult(boolean isSuccess, JSONObject response, String action, String msg) {\n"
				+ "mHandler.post(new Runnable() {\n"
				+ "@Override\n"
				+ "public void run() {\n\n"
				+ "}\n"
				+ "});\n"
				+ "}\n\n"
				+ "@Override\n"
				+ "public void onDestroy() {\n"
				+ ""
				+ lowName
				+ "View = null;\n" + "}\n\n" + "}\n";

		return content;
	}

}
