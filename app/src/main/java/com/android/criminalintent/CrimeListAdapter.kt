package com.android.criminalintent

import android.icu.text.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.criminalintent.databinding.ListItemCrimeBinding
import java.util.UUID

class CrimeHolder(
    private val binding: ListItemCrimeBinding)
    :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(
            crime: Crime,
            onCrimeClicked: (id: UUID) -> Unit
        ) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = DateFormat.getPatternInstance(DateFormat.YEAR_ABBR_MONTH_DAY).format(crime.date)
            binding.crimeSolved.visibility = if (crime.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.root.setOnClickListener { _ ->
                onCrimeClicked(crime.id)
            }
        }
    }

class CrimeListAdapter (
    private val crimes: List<Crime>,
    private val onCrimeClicked: (id: UUID) -> Unit
): RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime, onCrimeClicked)
    }
}