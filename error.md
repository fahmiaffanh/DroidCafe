class DatePickerFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onDateSet(datePicker: DatePicker?, year:Int, month:Int, day:Int){
        val activity:MainActivity? = activity as MainActivity?
        activity?.processDatePickerResult(year, month, day)
    }
    override fun onCreateDialog(savedInstanceState:Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val year:Int = c.get(Calendar.YEAR)
        val month:Int = c.get(Calendar.MONTH)
        val day:Int = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity!!, this, year,month,day)
    }
}

fun processDatePickerResult(year: Int, month: Int, day: Int){
        val monthString:String = Integer.toString(month+1)
        val dayString:String = Integer.toString(day)
        val yearString:String = Integer.toString(year)
        val dateMessage = "$monthString/$dayString/$yearString"
        Toast.makeText(this, "Date: $dateMessage",Toast.LENGTH_LONG).show()
    }
    fun onClickDate (view: View){
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }