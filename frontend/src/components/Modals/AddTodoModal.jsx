import PropTypes from "prop-types";
import React, { useState } from "react";
import ReactModal from "react-modal";
import Close from "@/assets/Modals/Close.svg?react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import styles from "@/styles/Modals/AddTodoModal.module.css";

const AddTodoModal = ({ onSubmit, onClose }) => {
  const [selectedDate, setSelectedDate] = useState(new Date());

  const handleClickSubmit = () => {
    onSubmit();
  };
  const handleClickCancel = () => {
    onClose();
  };

  return (
    <ReactModal
      isOpen={true}
      style={{
        overlay: {
          position: "fixed",
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          backgroundColor: "rgba(0, 0, 0, 0.75)",
        },
        content: {
          position: "absolute",
          width: "400px",
          height: "500px",
          top: "50%",
          left: "50%",
          transform: "translate(-50%, -50%)",
          background: "#fff",
          overflow: "auto",
          WebkitOverflowScrolling: "touch",
          borderRadius: "20px",
          outline: "none",
          padding: "20px",
        },
      }}
    >
      <button className={styles.close} onClick={handleClickCancel}>
        <Close />
      </button>

      <div className={styles.container}>
        <h1 className={styles.title}>일정 날짜</h1>
        <DatePicker
          selected={selectedDate}
          onChange={(date) => setSelectedDate(date)}
          dateFormat="yyyy년 MM월 dd일"
          className={styles.datePicker}
        />

        <h1 className={styles.title}>일정 이름</h1>
        <div>
          <select>
            <option>연차</option>
            <option>조퇴</option>
            <option>회의</option>
            <option>할일</option>
          </select>
        </div>

        <div>
          <h1 className={styles.title}>설명</h1>
          <textarea placeholder="일정에 대해 설명해주세요."></textarea>
        </div>

        <div className={styles.buttonBox}>
          <button
            onClick={handleClickCancel}
            className={`${styles.cancel} ${styles.button}`}
          >
            취소
          </button>
          <button
            onClick={handleClickSubmit}
            className={`${styles.confirm} ${styles.button}`}
          >
            완료
          </button>
        </div>
      </div>
    </ReactModal>
  );
};

AddTodoModal.propTypes = {
  onSubmit: PropTypes.func.isRequired,
  onClose: PropTypes.func.isRequired,
};

export default AddTodoModal;
