package com.ekachandra.loanmanagementapp.presentation.loan.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ekachandra.core.R
import com.ekachandra.core.domain.model.Loan
import com.ekachandra.core.ui.DocumentAdapter
import com.ekachandra.core.ui.RepaymentScheduleAdapter
import com.ekachandra.loanmanagementapp.databinding.FragmentLoanDetailBinding

class LoanDetailFragment : Fragment() {

    private var _binding: FragmentLoanDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var repaymentScheduleAdapter: RepaymentScheduleAdapter
    private lateinit var documentAdapter: DocumentAdapter

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

        setAdapter()

        @Suppress("DEPRECATION")
        val dataFromList = arguments?.getParcelable<Loan>("Loan")

        dataFromList?.let {
            populateLoanDetails(it)
        }

    }

    private fun setAdapter() {
        repaymentScheduleAdapter = RepaymentScheduleAdapter()
        documentAdapter = DocumentAdapter()

        binding.apply {
            rvRepaymentSchedule.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            rvRepaymentSchedule.adapter = repaymentScheduleAdapter
            rvDocument.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvDocument.adapter = documentAdapter
        }
    }

    private fun populateLoanDetails(loan: Loan) {
        binding.apply {
            tvRiskRating.text = getString(R.string.risk_rating, loan.riskRating)
            tvBorrowerName.text = getString(
                com.ekachandra.loanmanagementapp.R.string.borrower_name,
                loan.borrowerName
            )
            tvBorrowerEmail.text = getString(
                com.ekachandra.loanmanagementapp.R.string.email_borrower,
                loan.borrowerEmail
            )
            tvCreditScore.text =
                getString(com.ekachandra.loanmanagementapp.R.string.credit_score, loan.creditScore)
            tvCollateralType.text = getString(
                com.ekachandra.loanmanagementapp.R.string.collateral_type,
                loan.collateralType
            )
            tvCollateralValue.text = getString(
                com.ekachandra.loanmanagementapp.R.string.collateral_value,
                loan.collateralValue
            )
            tvLoanAmount.text = getString(R.string.loan_amount, loan.loanAmount)
            tvInterestRate.text = getString(R.string.interest_rate, loan.interestRate)
            tvTerm.text = getString(R.string.term_in_months, loan.term)
            tvPurpose.text = getString(R.string.purpose, loan.purpose)
            repaymentScheduleAdapter.submitList(loan.repaymentSchedule?.installments)
            loan.documents?.apply {
                if (this.isEmpty()) {
                    viewEmpty.root.visibility = View.VISIBLE
                } else {
                    viewEmpty.root.visibility = View.GONE
                    documentAdapter.submitList(loan.documents)
                }
            }
        }
    }

}