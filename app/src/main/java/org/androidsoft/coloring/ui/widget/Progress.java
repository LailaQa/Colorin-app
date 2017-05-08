
package org.androidsoft.coloring.ui.widget;

import android.os.Handler;
import android.os.Message;

public final class Progress {
	public static final int MAX = 100;

	public static final int MESSAGE_INCREMENT_PROGRESS = 1;
	public static final int MESSAGE_DONE_OK = 2;
	public static final int MESSAGE_DONE_ERROR = 3;

	public static final void sendIncrementProgress(Handler h, int diff) {
		Message m = Message.obtain(h, Progress.MESSAGE_INCREMENT_PROGRESS, diff, 0);
		h.sendMessage(m);
	}
}
