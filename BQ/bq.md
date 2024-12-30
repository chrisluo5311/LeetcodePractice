Prepare a story for each category
1. Teamwork
2. Leadership
3. Motivation
4. Challenge
5. Conflict
6. Learn new skill
7. Multitasking
8. Planning
9. Client Service
10. Failure

---

### 範本

【Behavioral Interview 行為面試】
面試官問:「分享你最驕傲的一個專案？」
不知道大家在面試時，有沒有被問過類似的問題。在台灣或美國，除了 Coding Interview，常常有 Behavioral Interview 來看看面試人員的「過人格特質」以及「問題處理」能力。
我最常分享的故事，則是以 Serverless 的架構為主的，並且搭配 STAR 答題策略進行：

▐ Situation (情境): 我在一間做線上支付的公司，每天有大量交易資料要彙整，並進行每日交易驗證。

▐ Task (任務/挑戰): 我主動發現，團隊使用 AWS ELB + EC2 作為運算資源，然而每天卻只有凌晨一點時，才有排程工作在 EC2 進行，造成大量不必要的成本花費。

▐ Action (行動): 我主動向主管提出改善方案，有鑒於這項需求:

1. 不用即時回應客戶
2. 一天中僅有少於一小時需要運算資源
3. 不需進行主機管理
   因此我建議改用 AWS Lambda + CloudWatch EventBridge 的架構去替代。最後，我僅僅用了一週的時間，就完善將系統從 EC2 > Lambda 架構。

▐ Result (結果): 我替這項作業省下了 95% 的成本花費，並且避免了約每個月 4 張的主機相關 Oncall Tickets，讓團隊能更專注在功能開發上，而非維護上。

藉由這個例子分享，我透過 Recruiter 的得知，面試官對我的解決方案非常有印象，因為他們公司內部也正有類似的流程要改善。我最後雖有拿到錄取，但還是忍痛選擇了其他公司 😛