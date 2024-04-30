package daniel.granados.appisaac.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import daniel.granados.appisaac.R
import daniel.granados.appisaac.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.txtPerfil
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val btnVerNombre = root.findViewById<Button>(R.id.btnVerNombre)
        val txtNombre = root.findViewById<TextView>(R.id.txtNombre)

        btnVerNombre.setOnClickListener {
            txtNombre.text = "Mi nombre es: Daniel Granados"
        }

        return root
    }
}