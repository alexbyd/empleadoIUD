// Ajusta el paquete según tu estructura

import data.EmpleadoDao;
import model.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FuncuionarioIUD {
    private JPanel panel1;
    private JTextField txtDocIdentificacion;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtFechaNacimiento;
    private JTextField txtEstadoCivil;
    private JButton btnCrear;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnListar;
    private JTable tblFuncionarios;
    private EmpleadoDao empleadoDao;

    public FuncuionarioIUD() {
        empleadoDao = new EmpleadoDao();

        // Asegurarse de que panel1 esté inicializado
        if (panel1 == null) {
            panel1 = new JPanel();
        }
        panel1.setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inicializar componentes
        txtDocIdentificacion = new JTextField(10);
        txtNombres = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtTelefono = new JTextField(15);
        txtDireccion = new JTextField(30);
        txtFechaNacimiento = new JTextField(10); // Formato: yyyy-MM-dd
        txtEstadoCivil = new JTextField(15);

        // Agregar etiquetas y campos al panel de entrada
        inputPanel.add(new JLabel("Documento Identificación:"));
        inputPanel.add(txtDocIdentificacion);
        inputPanel.add(new JLabel("Nombres:"));
        inputPanel.add(txtNombres);
        inputPanel.add(new JLabel("Apellidos:"));
        inputPanel.add(txtApellidos);
        inputPanel.add(new JLabel("Teléfono:"));
        inputPanel.add(txtTelefono);
        inputPanel.add(new JLabel("Dirección:"));
        inputPanel.add(txtDireccion);
        inputPanel.add(new JLabel("Fecha Nacimiento (yyyy-MM-dd):"));
        inputPanel.add(txtFechaNacimiento);
        inputPanel.add(new JLabel("Estado Civil:"));
        inputPanel.add(txtEstadoCivil);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnCrear = new JButton("Crear");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar Todos");
        buttonPanel.add(btnCrear);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnActualizar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnListar);

        // Tabla para mostrar funcionarios
        tblFuncionarios = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblFuncionarios);

        // Agregar paneles al panel principal
        panel1.add(inputPanel, BorderLayout.NORTH);
        panel1.add(buttonPanel, BorderLayout.CENTER);
        panel1.add(scrollPane, BorderLayout.SOUTH);

        // Configurar acciones de los botones
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = crearEmpleadoDesdeCampos();
                    empleadoDao.createEmpleado(empleado);
                    JOptionPane.showMessageDialog(panel1, "Funcionario creado exitosamente");
                    limpiarCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel1, "Error al crear funcionario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(panel1, "Formato de fecha inválido (use yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int docIdentificacion = Integer.parseInt(txtDocIdentificacion.getText());
                    Empleado empleado = empleadoDao.getEmpleadoById(docIdentificacion);
                    if (empleado != null) {
                        mostrarEmpleadoEnCampos(empleado);
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Funcionario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Ingrese un documento de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel1, "Error al buscar funcionario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = crearEmpleadoDesdeCampos();
                    empleadoDao.updateEmpleado(empleado);
                    JOptionPane.showMessageDialog(panel1, "Funcionario actualizado exitosamente");
                    limpiarCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel1, "Error al actualizar funcionario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(panel1, "Formato de fecha inválido (use yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int docIdentificacion = Integer.parseInt(txtDocIdentificacion.getText());
                    empleadoDao.deleteEmpleado(docIdentificacion);
                    JOptionPane.showMessageDialog(panel1, "Funcionario eliminado exitosamente");
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Ingrese un documento de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel1, "Error al eliminar funcionario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Empleado> empleados = empleadoDao.getEmpleados();
                    mostrarEmpleadosEnTabla(empleados);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel1, "Error al listar funcionarios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private Empleado crearEmpleadoDesdeCampos() throws ParseException {
        Empleado empleado = new Empleado();
        empleado.setDoc_identificacion(Integer.parseInt(txtDocIdentificacion.getText()));
        empleado.setNombre(txtNombres.getText());
        empleado.setApellido(txtApellidos.getText());
        empleado.setTelefono(txtTelefono.getText());
        empleado.setDireccion(txtDireccion.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        empleado.setFecha_nacimiento(new Date(sdf.parse(txtFechaNacimiento.getText()).getTime()));
        empleado.setEstado_civil(txtEstadoCivil.getText());
        return empleado;
    }

    private void mostrarEmpleadoEnCampos(Empleado empleado) {
        txtDocIdentificacion.setText(String.valueOf(empleado.getDoc_identificacion()));
        txtNombres.setText(empleado.getNombre());
        txtApellidos.setText(empleado.getApellido());
        txtTelefono.setText(empleado.getTelefono());
        txtDireccion.setText(empleado.getDireccion());
        txtFechaNacimiento.setText(new SimpleDateFormat("yyyy-MM-dd").format(empleado.getFecha_nacimiento()));
        txtEstadoCivil.setText(empleado.getEstado_civil());
    }

    private void limpiarCampos() {
        txtDocIdentificacion.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
        txtEstadoCivil.setText("");
    }

    private void mostrarEmpleadosEnTabla(List<Empleado> empleados) {
        String[] columnNames = {"Doc Identificación", "Nombres", "Apellidos", "Teléfono", "Dirección", "Fecha Nacimiento", "Estado Civil"};
        Object[][] data = new Object[empleados.size()][7];
        for (int i = 0; i < empleados.size(); i++) {
            Empleado emp = empleados.get(i);
            data[i][0] = emp.getDoc_identificacion();
            data[i][1] = emp.getNombre();
            data[i][2] = emp.getApellido();
            data[i][3] = emp.getTelefono();
            data[i][4] = emp.getDireccion();
            data[i][5] = new SimpleDateFormat("yyyy-MM-dd").format(emp.getFecha_nacimiento());
            data[i][6] = emp.getEstado_civil();
        }
        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void createUIComponents() {
        // Este método es llamado por IntelliJ UI Designer si el formulario XML está vinculado
        panel1 = new JPanel();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Funcionarios");
        frame.setContentPane(new FuncuionarioIUD().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}