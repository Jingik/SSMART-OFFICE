import React from "react";
import styles from "@/styles/Home/Todo.module.css";

const TodoList = ({ monthData }) => {
  return (
    <div>
      <ul className={styles.todoList}>
        {monthData && monthData.length > 0 ? (
          monthData.map((item, index) => (
            <li key={index} className={styles.todoItem}>
              <label>
                <input type="checkbox" className={styles.checkIcon} />
                <span className={styles.labelText}>{item.name}</span>
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
