"use client";

import st from "./Baekjoon.module.scss";
import { useAppDispatch } from "@/store/hooks";
import { setPrevCompMoving } from "@/store/modules/readme";

export default function PrevBtn() {
  const dispatch = useAppDispatch();

  return (
    <div className={st.button}>
      <button onClick={() => dispatch(setPrevCompMoving(0))}>이전</button>
    </div>
  );
}