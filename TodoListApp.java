/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolistapp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

public class TodoListApp extends JFrame {
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskNameField;
    private JTextField dueDateField;

    public TodoListApp() {
      
        setTitle("Todo List App");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        JScrollPane scrollPane = new JScrollPane(todoList);

        JLabel taskNameLabel = new JLabel("Task Name:");
        taskNameField = new JTextField(5);

        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateField = new JTextField(5);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameField.getText();
                String dueDate = dueDateField.getText();
                if (!taskName.isEmpty() && !dueDate.isEmpty()) {
                    todoListModel.addElement(taskName + " - Due: " + dueDate);
                    taskNameField.setText("");
                    dueDateField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter task name and due date.");
                }
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    todoListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a task to remove.");
                }
            }
        });

        // Layout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(taskNameLabel);
        inputPanel.add(taskNameField);
        inputPanel.add(dueDateLabel);
        inputPanel.add(dueDateField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TodoListApp app = new TodoListApp();
                app.setVisible(true);
            }
        });
    }
}
  

 
