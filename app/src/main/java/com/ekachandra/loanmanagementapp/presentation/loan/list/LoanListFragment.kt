package com.ekachandra.loanmanagementapp.presentation.loan.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ekachandra.core.data.Resource
import com.ekachandra.loanmanagementapp.databinding.FragmentLoanListBinding
import com.ekachandra.loanmanagementapp.presentation.loan.LoanViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoanListFragment : Fragment() {

    private var _binding: FragmentLoanListBinding? = null
    private val binding get() = _binding!!
    private val loanViewModel: LoanViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoanListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loanViewModel.getLoans().observe(viewLifecycleOwner) { loans ->
            when (loans) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    Toast.makeText(
                        requireActivity(),
                        loans.data?.get(0)?.purpose,
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.tvLoanList.text = loans.data?.get(0)?.purpose
                }

                is Resource.Error -> {
                }
            }
        }
    }

}