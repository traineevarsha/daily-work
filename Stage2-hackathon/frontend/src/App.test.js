import { render, screen } from "@testing-library/react";
import App from "./App";
beforeEach(() => {
  global.fetch = jest.fn((url) => {
    if (url === "http://localhost:5000/questions") {
      return Promise.resolve({
        json: () =>Promise.resolve([
            {questionId: 1,
              questionText: "What is your mother's maiden name?"
            },
            {questionId: 2,
              questionText: "What was the name of your first pet?"
            },
            { questionId: 3,
              questionText: "What is your favorite food?"
            },
            {questionId: 4,
              questionText: "What is the name of your first school?"
            }])});
}});
});
test("loads questions from backend and displays them in dropdown", async () =>{
  render(<App />);
  const option = await screen.findByText("What is your mother's maiden name?");
  expect(option).toBeInTheDocument();
});
test("displays question dropdowns for selecting security questions", async () =>{
  render(<App />);
  const dropdowns = await screen.findAllByDisplayValue("Select question");
  expect(dropdowns.length).toBeGreaterThan(0);
});
test("renders answer input fields for user input", async () =>{
  render(<App />);
  const answerInputs = await screen.findAllByPlaceholderText("Answer");
  expect(answerInputs.length).toBeGreaterThan(0);
});
test("renders confirm answer input fields for verification", async () =>{
  render(<App />);
  const confirmInputs = await screen.findAllByPlaceholderText("Confirm Answer");
  expect(confirmInputs.length).toBeGreaterThan(0);
});
test("hide answers checkbox toggles visibility", async () =>{
  render(<App />);
  const checkbox = await screen.findByLabelText("Hide Answers");
  expect(checkbox.checked).toBe(false);
  checkbox.click();
  expect(checkbox.checked).toBe(true);
});