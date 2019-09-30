import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.droidcafe.Alert
import com.example.droidcafe.MainActivity
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onDateSet(datePicker: DatePicker?, year:Int, month:Int, day:Int){
        val activity = activity as Alert?
        activity?.processDatePickerResult(year, month, day)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year:Int = c.get(Calendar.YEAR)
        val month:Int = c.get(Calendar.MONTH)
        val day:Int = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity!!, this, year,month,day)
    }
}

