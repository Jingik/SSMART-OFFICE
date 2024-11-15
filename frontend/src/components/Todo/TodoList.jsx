import React from "react";
import useAttendanceStore from "@/store/useAttendanceStore";
import styles from "@/styles/Home/Todo.module.css";
import Modify from "@/assets/Common/Modify.svg?react";

const TodoList = ({ todos = [] }) => {
  return (
    <div>
      <ul className={styles.todoList}>
        {todos.length > 0 ? (
          todos.map((item, index) => (
            <li key={index} className={styles.todoItem}>
              <label>
                <input type="checkbox" className={styles.checkIcon} />
                <span className={styles.labelText}>{item.name}</span>
                <Modify className={styles.modifyIcon} />
              </label>
            </li>
          ))
        ) : (
          <li className={styles.todoItem}>일정이 없습니다.</li>
        )}
      </ul>
    </div>
  );
};

export default TodoList;
