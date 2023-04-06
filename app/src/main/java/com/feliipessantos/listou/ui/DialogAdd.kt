package com.feliipessantos.listou.ui

import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.feliipessantos.listou.R
import com.feliipessantos.listou.databinding.DialogAddBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogAdd : BottomSheetDialogFragment() {
    private lateinit var _binding: DialogAddBinding
    private lateinit var listTaskAdapter: ListTaskAdapter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handlerViews()
        _binding.btNewList.typeface = Typeface.DEFAULT_BOLD

        val listItem = mutableListOf<String>()

        val listView = _binding.ListViewTask
        listTaskAdapter = ListTaskAdapter(requireContext(), listItem)
        listView.adapter = listTaskAdapter

        _binding.btAddItemList.setOnClickListener {
            addItem(listItem)
        }

        _binding.InputTaskLayout.setEndIconOnClickListener {
            addItem(listItem)
        }
    }

    private fun addItem(listItem: MutableList<String>) {
        val task = _binding.InputTask
        if (_binding.InputTask.text.toString().isNotEmpty()) {
            listItem.add(task.text.toString())
            task.setText("")
            listTaskAdapter.notifyDataSetChanged()
        }
    }

    private fun handlerViews() {
        val btNewList = _binding.btNewList
        val btAddExist = _binding.btAddExist
        val inAnim = AnimationUtils.loadAnimation(requireContext(), android.R.anim.slide_in_left)

        btNewList.setOnClickListener {
            _binding.viewNewList.visibility = View.VISIBLE
            _binding.viewExistList.visibility = View.GONE
            _binding.viewNewList.startAnimation(inAnim)

            btNewList.typeface = Typeface.DEFAULT_BOLD
            btAddExist.typeface = Typeface.DEFAULT

            btNewList.setBackgroundResource(R.drawable.underline_bt_add)
            btAddExist.setBackgroundResource(R.color.primary)
        }


        btAddExist.setOnClickListener {
            _binding.viewExistList.visibility = View.VISIBLE
            _binding.viewNewList.visibility = View.GONE
            _binding.viewExistList.startAnimation(inAnim)

            btNewList.typeface = Typeface.DEFAULT
            btAddExist.typeface = Typeface.DEFAULT_BOLD

            btAddExist.setBackgroundResource(R.drawable.underline_bt_add)
            btNewList.setBackgroundResource(R.color.primary)
        }
    }
}
