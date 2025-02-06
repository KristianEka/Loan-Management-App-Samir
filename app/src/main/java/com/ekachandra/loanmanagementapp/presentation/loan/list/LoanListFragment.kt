package com.ekachandra.loanmanagementapp.presentation.loan.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ekachandra.core.data.Resource
import com.ekachandra.core.ui.LoanAdapter
import com.ekachandra.loanmanagementapp.databinding.FragmentLoanListBinding
import com.ekachandra.loanmanagementapp.presentation.loan.LoanViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoanListFragment : Fragment() {

    private var _binding: FragmentLoanListBinding? = null
    private val binding get() = _binding!!
    private val loanViewModel: LoanViewModel by viewModel()

    private lateinit var adapter: LoanAdapter

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

        setAdapter()

        loanViewModel.getLoans().observe(viewLifecycleOwner) { loans ->
            when (loans) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    adapter.submitList(loans.data)

                }

                is Resource.Error -> {
                }
            }
        }
    }

    private fun setAdapter() {
        adapter = LoanAdapter()

        binding.apply {
            rvLoan.layoutManager = LinearLayoutManager(requireContext())
            rvLoan.setHasFixedSize(true)
            rvLoan.adapter = adapter
        }
    }

}