# LF Decentralized Trust Mentorship Application: Hiero SDK V3

**Applicant:** Kalema Kosea
**Project:** Hiero: Designing the Next-Generation Hiero SDK Architecture (SDK V3)

---

## 1. Why are you interested in the project(s) you're applying to?

I am deeply interested in the Hiero SDK V3 project because it sits at the intersection of modern API design, software architecture, and the future of decentralized trust. My recent work has involved building complex, multi-module systems (like the Sonar Cryptography plugin), where I've seen firsthand how critical a well-designed, language-agnostic interface is for consistency and developer experience.

Specifically, the project's focus on:
- **Language-agnostic API design:** I find the challenge of creating a unified interface across diverse languages (Rust, C++, Java, etc.) fascinating.
- **AI-assisted development:** As someone who actively uses AI tools to accelerate my workflow, I am eager to contribute to the formal investigation of how these tools can improve SDK development and documentation adherence.
- **Developer Experience (DX):** I believe that the success of any platform depends on the usability of its tools, and I want to help Hiero provide a world-class experience for its developers.

## 2. What experience and knowledge/skills do you have that are applicable to the requirements?

I have a strong background in systems programming and static analysis, which aligns well with the technical requirements of this project:

- **Multi-language Proficiency:** I have experience working with **C++ (ANTLR4 integration)**, **Java (SonarQube engine development)**, and **Python (Semantic analysis)**. I am comfortable switching between these contexts and understanding the idiomatic "best practices" for each.
- **API Design & Architecture:** In my work on `sonar-cryptography`, I've helped design the translation layer that maps language-specific AST findings into a common cryptographic model (CBOM).
- **Prototyping SDK V3:** I have already developed a **cross-language PoC (Java and C++)** for the Hiero SDK V3. I've implemented a **functional, immutable API** for keys and transactions that maintains architectural consistency across different languages. This includes executable demonstrations and clear documentation on how the V3 "meta-language" projects onto Java and C++ paradigms.
- **Collaborative Development:** I am an active contributor to open-source projects like **cbomkit**. I am currently working with their maintainers to integrate native C/C++ support into the `sonar-cryptography` plugin, and I am highly responsive to peer review and community standards (e.g., refactoring large contributions into modular, focused pull requests).

## 3. What do you hope to get out of this experience?

Through this mentorship, I hope to:
- Deepen my understanding of the **Hiero ecosystem** and how decentralized networks communicate.
- Master the art of **future-proof API design** under the guidance of experienced mentors like Hendrik Ebbers.
- Contribute meaningful PoCs that will shape the future of Hiero SDKs.
- Quantify and document the impact of **AI-assisted development** to help the community adopt these tools effectively.

## 4. AI-Assisted Development Vision

In this project, I envision using AI tools (like Claude Code) not just for code completion, but as a "context-aware architect." In my PoC work, I used AI to:
- **Enforce Architectural Patterns:** Ensuring that all transaction modifications return new immutable instances, adhering to the V3 functional design.
- **Automate JCA Integration:** Generating the boilerplate for Java Cryptography Architecture (JCA) while keeping the public API surface clean and language-agnostic.
- **Verify API compliance:** Automatically checking if new PoC implementations adhere to the language-agnostic meta-language guidelines.
- **Accelerate Documentation:** Generating clear, guideline-compliant documentation from the code.
