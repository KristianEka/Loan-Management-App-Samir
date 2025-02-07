package com.ekachandra.loanmanagementapp.presentation.loan.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

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
        getLoansData()

        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            getLoansData()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setAdapter() {
        adapter = LoanAdapter()
        adapter.onItemClick = { selectedData ->
            val action =
                LoanListFragmentDirections.actionLoanListFragmentToLoanDetailFragment(selectedData)
            findNavController().navigate(action)
        }

        binding.apply {
            rvLoan.layoutManager = LinearLayoutManager(requireContext())
            rvLoan.setHasFixedSize(true)
            rvLoan.adapter = adapter
        }
    }

    private fun stateLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun stateEmpty(isEmpty: Boolean) {
        binding.apply {
            viewEmpty.root.visibility = if (isEmpty) View.VISIBLE else View.GONE
        }
    }

    private fun stateError(isError: Boolean, message: String? = null) {
        binding.apply {
            if (isError) {
                viewError.root.visibility = View.VISIBLE
                if (message != null) {
                    viewError.tvError.text = message
                }
            } else {
                viewError.root.visibility = View.GONE
            }
        }
    }

    private fun getLoansData() {
        loanViewModel.getLoans().observe(viewLifecycleOwner) { loans ->
            when (loans) {
                is Resource.Loading -> {
                    stateLoading(true)
                    stateEmpty(false)
                    stateError(false)
                }

                is Resource.Success -> {
                    stateLoading(false)
                    stateEmpty(loans.data.isNullOrEmpty())
                    stateError(false)
                    adapter.submitList(loans.data)

                }

                is Resource.Error -> {
                    stateLoading(false)
                    stateEmpty(false)
                    stateError(true, loans.message)
                }
            }
        }
    }

}