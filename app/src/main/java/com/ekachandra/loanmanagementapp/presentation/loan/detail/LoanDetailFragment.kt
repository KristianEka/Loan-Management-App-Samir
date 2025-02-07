package com.ekachandra.loanmanagementapp.presentation.loan.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ekachandra.core.domain.model.Loan
import com.ekachandra.loanmanagementapp.databinding.FragmentLoanDetailBinding

class LoanDetailFragment : Fragment() {

    private var _binding: FragmentLoanDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoanDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        @Suppress("DEPRECATION")
        val dataFromList = arguments?.getParcelable<Loan>("Loan")

        Log.d("TEST_DATA", "onViewCreated: $dataFromList")
        binding.tvLoanDetail.text = dataFromList?.purpose

    }

}